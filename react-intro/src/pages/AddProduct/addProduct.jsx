import React, { useState } from 'react';

export default function AddProduct() {
  const [newProduct, setNewProduct] = useState({
    title: '',
    // Diğer ürün verilerini buraya ekleyebilirsiniz
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
        // İsterseniz burada başka bir sayfaya yönlendirebilirsiniz
      } else {
        console.error('Ürün ekleme hatası:', response.statusText);
      }
    } catch (error) {
      console.error('Ürün ekleme hatası:', error.message);
    }
  };

  return (
    <div>
      <h2>Yeni Ürün Ekle</h2>
      <form>
        <label>
          Title:
          <input type="text" name="title" value={newProduct.title} onChange={handleInputChange} />
        </label>
        {/* Diğer ürün verileri için giriş alanlarını buraya ekleyebilirsiniz */}
        <button type="button" onClick={handleAddProduct}>
          Ürünü Ekle
        </button>
      </form>
    </div>
  );
}
