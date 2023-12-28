import React, { useEffect, useState } from 'react';
import ProductCard from '../../components/ProductCard/ProductCard';
import axios from 'axios';
import { Container, Row, Col } from 'react-bootstrap';

export default function Homepage() {
  const [products, setProducts] = useState([]);

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

  return (
    <Container fluid>
      <Row>
        <Col xs={12} id="page-content-wrapper">
          <div className='container mt-5'>
            <div className='row'>
              <div className='col-lg-9'>
                <div className='row'>
                  {products.map(product => (
                    <div className='col-lg-3 col-md-6 col-12 mb-5' key={product.id}>
                      <ProductCard product={product} />
                    </div>
                  ))}
                </div>
              </div>
            </div>
          </div>
        </Col>
      </Row>
    </Container>
  );
}
