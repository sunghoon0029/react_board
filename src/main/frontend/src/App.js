import React from "react";
import { Route, Routes } from "react-router-dom";
import Home from "./routes/Home";
import BoardDetail from "./routes/BoardDetail";
import BoardWrite from "./routes/BoardWrite";
import BoardUpdate from "./routes/BoardUpdate";
import BoardList from "./routes/BoardList";
import BoardPagingList from "./routes/BoardPagingList";

const App = () => {

  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/board" element={<BoardList />} />
      {/* <Route path="/board" element={<BoardPagingList />} /> */}
      <Route path="/board/:id" element={<BoardDetail />} />
      <Route path="/write" element={<BoardWrite />} />
      <Route path="/update/:id" element={<BoardUpdate />} />
    </Routes>
  );
}

export default App;
