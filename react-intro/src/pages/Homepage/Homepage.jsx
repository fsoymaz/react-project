import React, { useEffect, useState } from 'react';
import ProductCard from '../../components/ProductCard/ProductCard';
import axios from 'axios';

export default function Homepage() {
  const [products, setProducts] = useState([]);
  const [newProduct, setNewProduct] = useState({
    title: '',
    // Diğer ürün verilerini buraya ekleyebilirsiniz
  });

  useEffect(() => {
    fetchProducts();
  }, []);

  const fetchProducts = async () => {
    try {
      let response = await axios.get('https://dummyjson.com/products');
      setProducts(response.data.products);
    } catch (error) {
      console.error('Ürünleri getirme hatası:', error);
    }
  };

  const handleProductDelete = (productId) => {
    axios.delete(`https://dummyjson.com/products/${productId}`)
      .then(() => {
        fetchProducts();
        console.log('Ürün başarıyla silindi');
      })
      .catch(error => {
        console.error('Ürün silme hatası:', error);
      });
  };

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
        fetchProducts(); // Ürün ekledikten sonra listeyi güncelle
        setNewProduct({ title: '' }); // Formu temizle
      } else {
        console.error('Ürün ekleme hatası:', response.statusText);
      }
    } catch (error) {
      console.error('Ürün ekleme hatası:', error.message);
    }
  };

  return (
    <div className='container mt-5'>
      <div className='row'>
        <div className='col-lg-3'>
          {/* Sol menü/panel */}
          <div className='mt-3'>
            <h2>Yeni Ürün Ekle</h2>
            <form>
              <label>
                Title:
                <input type='text' name='title' value={newProduct.title} onChange={handleInputChange} />
              </label>
              {/* Diğer ürün verileri için giriş alanları ekleyebilirsiniz */}
              <button type='button' className='btn btn-primary mt-2' onClick={handleAddProduct}>
                Ürünü Ekle
              </button>
            </form>
          </div>
        </div>
        <div className='col-lg-9'>
          {/* Ürün kartları */}
          <div className='row'>
            {products.map(product => (
              <div className='col-lg-3 col-md-6 col-12 mb-5' key={product.id}>
                <ProductCard product={product} onDelete={() => handleProductDelete(product.id)} />
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}
