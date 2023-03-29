import { useState } from "react";
import { Canvas, useFrame, ThreeElements, Vector3 } from "@react-three/fiber";
import Wall from "./Wall";
import { GameCellDto, GameMapDto } from "../api/mutliplayerpacman";
import THREE from "three";

type Props = {
  gmd: GameMapDto;
};

const CellSize = 3;

const GameMap: React.FC<Props> = ({ gmd }) => {
  const [unit, setUnit] = useState(1);

  // let camera = new THREE.PerspectiveCamera(
  //   45,
  //   window.innerWidth / window.innerHeight,
  //   1,
  //   1000
  // ); // Specify camera type like this
  // camera.position.set(0, 2.5, 5); // Set position like this
  // camera.lookAt(new THREE.Vector3(0, 0, 0)); // Set look at coordinate like this
  return (
    <div style={{ height: "100vh", width: "100vw" }}>
      <Canvas
        style={{ backgroundColor: "white" }}
        camera={{ position: [0, 0, unit * 15] }}
      >
        <ambientLight />
        <pointLight position={[10, 10, 10]} />
        {/* <Wall
          meshprops={{
            position: [0, 0, 0],
          }}
          unit={unit}
        /> */}
        {getWalls(gmd, unit)}
      </Canvas>
    </div>
  );
};

function getWalls(gmd: GameMapDto, unit: number): JSX.Element[] {
  let res = [];
  const top = (CellSize * unit * gmd.ydim) / 2;
  const left = (-CellSize * unit * gmd.xdim) / 2;

  for (let i = 0; i < gmd.ydim; i++) {
    for (let j = 0; j < gmd.xdim; j++) {
      let gc: GameCellDto = gmd.cells[i][j];
      const center = [
        left + j * unit * CellSize + unit / 2,
        top - (i * unit * CellSize + unit / 2),
      ];
      if (gc.up)
        res.push(
          <Wall
            key={i + "," + j + "u"}
            meshprops={{
              position: [center[0], center[1] + unit * 1.25, 0],
            }}
            dimensions={[CellSize * unit, unit, unit]}
            unit={unit}
          />
        );
      if (gc.down) {
        res.push(
          <Wall
            key={i + "," + j + "d"}
            meshprops={{
              position: [center[0], center[1] - unit * 1.25, 0],
            }}
            dimensions={[CellSize * unit, unit, unit]}
            unit={unit}
          />
        );
      }
      if (gc.left) {
        res.push(
          <Wall
            key={i + "," + j + "l"}
            meshprops={{
              position: [center[0] - unit * 1.25, center[1], 0],
            }}
            dimensions={[unit, CellSize * unit, unit]}
            unit={unit}
          />
        );
      }
      if (gc.right) {
        res.push(
          <Wall
            key={i + "," + j + "r"}
            meshprops={{
              position: [center[0] + unit * 1.25, center[1], 0],
            }}
            dimensions={[unit, CellSize * unit, unit]}
            unit={unit}
          />
        );
      }
    }
  }
  return res;
}

export default GameMap;
