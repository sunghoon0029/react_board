import React from 'react';
import { Route, Router, Routes } from 'react-router-dom';
import Navbar from './components/Navbar';

function App() {
  
  return (
    <>
    <Router>
      <Navbar />
      <Routes>
        <Route path='/' exact />
      </Routes>
    </Router>
    </>
  );
}

export default App;
