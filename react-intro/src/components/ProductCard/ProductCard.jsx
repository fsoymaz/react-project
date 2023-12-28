import React from 'react';
import { Link } from 'react-router-dom';

export default function ProductCard(props) {
  const handleDelete = async () => {
    try {
      // Silme işlemi için istek atılıyor
      const response = await fetch(`https://dummyjson.com/products/{props.product.id}`, {
        method: 'DELETE',
      });

      if (response.ok) {
        // TODO: Silinen ürünü sayfadan kaldırma işlemi burada yapılabilir
        console.log('Ürün başarıyla silindi');
      } else {
        console.error('Ürün silme hatası:', response.statusText);
      }
    } catch (error) {
      console.error('Ürün silme hatası:', error.message);
    }
  };

  return (
    <div className='card'>
      <img src={props.product.thumbnail} className='card-img-top' alt="..." />
      <div className='card-body'>
        <h5 className='card-title'>{props.product.title}</h5>
        <p className='card-text'>{props.product.description}</p>
        <Link to={`/product-detail/${props.product.id}`} className='btn btn-primary'>Detay</Link>
        <button className='btn btn-danger' onClick={handleDelete}>Sil</button>
      </div>
    </div>
  );
}
