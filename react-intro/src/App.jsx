// App.jsx
import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import Homepage from './pages/Homepage/Homepage';
import About from './pages/About/About';
import Navbar from './components/Navbar/Navbar';
import AddNewProduct from './pages/AddNewProduct/AddNewProduct';
import ProductDetail from './pages/ProductDetail/ProductDetail';

function App() {
  return (
    <>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route path="/" element={<Homepage />} />
          <Route path="/about" element={<About />} />
          <Route path="/product-detail/:id" element={<ProductDetail />} />

          <Route path="/add-product" element={<AddNewProduct />} />
          <Route path="*" element={<h1>Not Found</h1>} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
