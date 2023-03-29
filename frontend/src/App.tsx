import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import GameMap from "./components/GameMap";
import { GameMapDto } from "./api/mutliplayerpacman";

function App() {
  const [count, setCount] = useState(0);
  let gmd: GameMapDto = {
    id: 6,
    name: "random",
    xdim: 5,
    ydim: 5,
    cells: [
      [
        { left: false, down: true, right: true, up: true, power: "NONE" },
        { left: true, down: false, right: true, up: false, power: "NONE" },
        { left: true, down: false, right: false, up: false, power: "NONE" },
        { left: false, down: false, right: false, up: true, power: "NONE" },
        { left: false, down: false, right: false, up: false, power: "NONE" },
      ],
      [
        { left: true, down: false, right: true, up: true, power: "NONE" },
        { left: true, down: false, right: true, up: false, power: "NONE" },
        { left: true, down: false, right: true, up: false, power: "NONE" },
        { left: true, down: false, right: true, up: false, power: "NONE" },
        { left: true, down: true, right: true, up: false, power: "NONE" },
      ],
      [
        { left: true, down: false, right: false, up: false, power: "NONE" },
        { left: false, down: true, right: true, up: false, power: "NONE" },
        { left: true, down: false, right: false, up: false, power: "NONE" },
        { left: false, down: false, right: false, up: false, power: "NONE" },
        { left: false, down: false, right: true, up: true, power: "NONE" },
      ],
      [
        { left: true, down: false, right: true, up: false, power: "NONE" },
        { left: true, down: false, right: false, up: true, power: "NONE" },
        { left: false, down: false, right: true, up: false, power: "NONE" },
        { left: true, down: false, right: true, up: false, power: "NONE" },
        { left: true, down: false, right: false, up: false, power: "NONE" },
      ],
      [
        { left: false, down: true, right: false, up: false, power: "NONE" },
        { left: false, down: true, right: true, up: false, power: "NONE" },
        { left: true, down: true, right: false, up: false, power: "NONE" },
        { left: false, down: true, right: false, up: false, power: "NONE" },
        { left: false, down: false, right: false, up: false, power: "NONE" },
      ],
    ],
    createdOn: new Date("2023-03-28T19:56:26.455987"),
    updatedOn: new Date("2023-03-28T19:56:26.456243"),
  };
  return (
    <div className="App">
      <GameMap gmd={gmd} />
    </div>
  );
}

export default App;
