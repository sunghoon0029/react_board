import React from "react";
import { Route, Routes } from "react-router-dom";
import BoardList from "./routes/BoardList";
import Home from "./routes/Home";
import BoardDetail from "./routes/BoardDetail";

const App = () => {

  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/board" element={<BoardList />} />
      <Route path="/board/:id" element={<BoardDetail />} />
    </Routes>
  );
}

export default App;
