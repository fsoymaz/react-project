import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

export default function ProductDetail() {
    let {id} =useParams()

    const [product, setProduct] = useState({})

    useEffect(() =>{
        fetchProductDetail();
    },[]);

    const fetchProductDetail = async () => {
        let response = await axios.get("https://dummyjson.com/products/"+id);
        setProduct(response.data);
        console.log(response.data)
    }

    return (
        <div className="container mt-5 md-10" style={{ width: '25rem', display: 'flex', alignItems: 'center', justifyContent: 'center' }}>
            <div className="card">
                <img src={product.thumbnail} className="card-img-top rounded" alt="..." style={{ maxWidth: '100%', maxHeight: '60%', height: 'auto'  }}/>
                    <div className="card-body">
                        <h5 className="card-title">{product.title}</h5>
                        <p className="card-text">{product.description}</p>
                    </div>
                    <ul className="list-group list-group-flush">
                        <li className="list-group-item">{product.title}</li>
                        <li className="list-group-item">{product.brand}</li>
                        <li className="list-group-item">{product.price}</li>
                        <li className="list-group-item">{product.category}</li>
                        <li className="list-group-item">{product.rating}</li>
                    </ul>
            </div>
        </div>
    )
}