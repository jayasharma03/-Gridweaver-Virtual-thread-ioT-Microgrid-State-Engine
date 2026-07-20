
function SolarCard() {
  return (
    <div className="card">
      <h2>☀ Solar</h2>
      <h3>75 kW</h3>

      <div className="progress">
        <div className="solar-fill"></div>
      </div>

      <p>Generation: Good</p>
    </div>
  );
}

export default SolarCard;