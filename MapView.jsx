import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import "leaflet/dist/leaflet.css";

function MapView() {
  return (
    <div
      style={{
        width: "100%",
        height: "450px",
        marginTop: "20px",
      }}
    >
      <MapContainer
        center={[28.6139, 77.2090]}
        zoom={13}
        style={{
          width: "100%",
          height: "100%",
          borderRadius: "10px",
        }}
      >
        <TileLayer
          attribution='&copy; OpenStreetMap contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />

        {/* Grid Station */}
        <Marker position={[28.6139, 77.2090]}>
          <Popup>⚡ Grid Station</Popup>
        </Marker>

        {/* Solar Plant */}
        <Marker position={[28.6200, 77.2150]}>
          <Popup>☀️ Solar Plant</Popup>
        </Marker>

        {/* Battery */}
        <Marker position={[28.6080, 77.2050]}>
          <Popup>🔋 Battery Station</Popup>
        </Marker>

        {/* Load Node */}
        <Marker position={[28.6150, 77.2200]}>
          <Popup>🏠 Load Node</Popup>
        </Marker>
      </MapContainer>
    </div>
  );
}

export default MapView;