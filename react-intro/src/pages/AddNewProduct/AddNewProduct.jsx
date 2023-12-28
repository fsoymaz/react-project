import React, { useState } from 'react';

export default function AddNewProduct() {
  const [newProduct, setNewProduct] = useState({
    title: '',
    description: '',
    price: '',
    category: '',
    image: '',
    stock: '',
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewProduct((prevProduct) => ({
      ...prevProduct,
      [name]: value,
    }));
  };

  const handleAddProduct = async () => {
    try {
      const response = await fetch('https://dummyjson.com/products/add', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(newProduct),
      });

      if (response.ok) {
        const addedProduct = await response.json();
        console.log('Yeni ürün eklendi:', addedProduct);
      } else {
        console.error('Ürün ekleme hatası:', response.statusText);
      }
    } catch (error) {
      console.error('Ürün ekleme hatası:', error.message);
    }
  };

  return (
    <div className="d-flex justify-content-center text-lg pt-3">
      <form className="add-product-form">
        <div className="form-group">
          <label>
            Image URL:
            <input type="text" name="image" value={newProduct.image} onChange={handleInputChange} className="form-control" />
          </label>
        </div>
        <div className="form-group">
          <label>
            Description:
            <input type="text" name="description" value={newProduct.description} onChange={handleInputChange} className="form-control" />
          </label>
        </div>
        <div className="form-group">
          <label>
            Model:
            <input type="text" name="model" value={newProduct.model} onChange={handleInputChange} className="form-control" />
          </label>
        </div>
        <div className="form-group">
          <label>
            Brand:
            <input type="text" name="brand" value={newProduct.brand} onChange={handleInputChange} className="form-control" />
          </label>
        </div>
        <div className="form-group">
          <label>
            Price:
            <input type="number" name="price" value={newProduct.price} onChange={handleInputChange} className="form-control" />
          </label>
        </div>
        <div className="form-group">
          <label>
            Category:
            <input type="text" name="category" value={newProduct.category} onChange={handleInputChange} className="form-control" />
          </label>
        </div>
        <div className="form-group">
          <label>
            Stock:
            <input type="number" name="stock" value={newProduct.stock} onChange={handleInputChange} className="form-control" />
          </label>
        </div>
        <button type="button" onClick={handleAddProduct} className="btn btn-primary">
          Ürünü Ekle
        </button>
      </form>
    </div>
  );
}