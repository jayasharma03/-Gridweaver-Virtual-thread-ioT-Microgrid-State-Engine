import React, { useState, useEffect } from 'react';
import { MapContainer, TileLayer, CircleMarker, Popup } from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import SockJS from 'sockjs-client';
import { Stomp } from '@stomp/stompjs';

// टाइप्स के आधार पर कलर्स सेट करना
const nodeColors = {
    Grid: '#3498db',      // Blue for Grid
    Solar: '#f1c40f',     // Yellow for Solar
    Battery: '#2ecc71',   // Green for Battery
    Offline: '#e74c3c'    // Red if offline
};

function MapView() {
    const cityCenter = [28.4528, 77.4200];
    
    // शुरुआती नोड्स डेटा
    const [nodes, setNodes] = useState([
        { id: 1, name: "Main Grid Substation", position: [28.4528, 77.4200], status: "Online", type: "Grid" },
        { id: 2, name: "Solar Generation Plant", position: [28.4600, 77.4300], status: "Online", type: "Solar" },
        { id: 3, name: "Battery Storage Bank", position: [28.4450, 77.4100], status: "Online", type: "Battery" }
    ]);

    // WebSocket लाइव अपडेट्स
    useEffect(() => {
        const socket = new SockJS("http://localhost:8080/ws-microgrid");
        const stompClient = Stomp.over(socket);

        stompClient.connect({}, (frame) => {
            console.log('Connected: ' + frame);
            
            stompClient.subscribe('/topic/live-grid', (message) => {
                if (message.body) {
                    const updatedNodes = JSON.parse(message.body);
                    setNodes(updatedNodes); 
                }
            });
        }, (error) => {
            console.error('WebSocket Error: ', error);
        });

        return () => {
            if (stompClient && stompClient.connected) {
                stompClient.disconnect(() => {
                    console.log("WebSocket disconnected successfully");
                });
            }
        };
    }, []);

    return (
        <div style={{ padding: "20px", background: "#1a1f3c", borderRadius: "12px", marginTop: "20px" }}>
            <h3 style={{ color: "#ffffff", marginBottom: "15px", fontFamily: "sans-serif" }}>
                Microgrid Live Network Map
            </h3>

            <div style={{ height: "450px", width: "100%", borderRadius: "8px", overflow: "hidden" }}>
                <MapContainer center={cityCenter} zoom={13} style={{ height: "100%", width: "100%" }}>
                    
                    {/* रिलायबल ओपनस्ट्रीटमैप टाइल लेयर */}
                    <TileLayer
                        attribution='&copy; <a href="https://openstreetmap.org">OpenStreetMap</a> contributors'
                        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                    />

                    {/* यहाँ Marker की जगह CircleMarker का इस्तेमाल किया गया है ताकि इमेज की ज़रूरत ही न पड़े */}
                    {nodes.map((node) => {
                        const markerColor = node.status === 'Offline' 
                            ? nodeColors.Offline 
                            : (nodeColors[node.type] || nodeColors.Grid);

                        return (
                            <CircleMarker 
                                key={node.id} 
                                center={node.position}
                                radius={10}               // नोड का साइज
                                fillColor={markerColor}    // अंदर का रंग
                                color="#ffffff"            // बॉर्डर का सफेद रंग
                                weight={2}                 // बॉर्डर की मोटाई
                                fillOpacity={0.9}          // नोड की ओपेसिटी
                            >
                                <Popup>
                                    <div style={{ fontFamily: "sans-serif", fontSize: "14px", color: "#333" }}>
                                        <strong style={{ fontSize: "15px" }}>{node.name}</strong><br />
                                        <span style={{ color: "#666" }}>Type:</span> {node.type}<br />
                                        <span>Status: 
                                            <b style={{ color: node.status === 'Online' ? '#2ecc71' : '#e74c3c' }}>
                                                {" "}{node.status}
                                            </b>
                                        </span>
                                    </div>
                                </Popup>
                            </CircleMarker>
                        );
                    })}

                </MapContainer>
            </div>
        </div>
    );
}

export default MapView;