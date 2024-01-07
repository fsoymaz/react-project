import { Icon, Menu, Table, Button } from 'semantic-ui-react';
import React, { useState, useEffect } from 'react';
import BrandService from '../services/brandService';
import { Link } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { addToCart, removeFromCart } from '../store/actions/cartActions';
import { toast } from 'react-toastify';
import { useSelector } from 'react-redux';


export default function ProductList() {
    const dispatch = useDispatch();
    const [brands, setBrands] = useState([]);
    const { cartItems } = useSelector(state => state.cart)
    useEffect(() => {
        let brandService = new BrandService();
        brandService
            .getBrands()
            .then(result => {
                setBrands(result.data);
            })
            .catch(error => console.log(error.message));
    }, []);

    const handleAddToCart = (product) => {
        dispatch(addToCart(product));
        toast.success(`${product.name} sepete eklendi!`)
    }

    const handleRemoveFromCart = (product) => {
        const productInCart = cartItems.find(item => item.product.id === product.id);
        if (!productInCart) {
            toast.info(`Sepette ${product.name} ürünü bulunamadı!`);
            return;
        }
        dispatch(removeFromCart(product));
        toast.error(`${product.name} sepetten silindi!`);
    }

    return (
        <div>
            <Table celled>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>Brand Name</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>
                <Table.Body>

                    {brands && brands.map(brand => (
                        <Table.Row key={brand.id}>
                            <Table.Cell><Link to={"/products/" + brand.id}>{brand.name}</Link></Table.Cell>
                            <Table.Cell><Button onClick={() => handleAddToCart(brand)}>Sepete Ekle</Button></Table.Cell>
                            <Table.Cell><Button onClick={() => handleRemoveFromCart(brand)}>Sepetten Çıkar</Button></Table.Cell>
                        </Table.Row>
                    ))}
                </Table.Body>

                <Table.Footer>
                    <Table.Row>
                        <Table.HeaderCell colSpan='1'>
                            <Menu floated='right' pagination>
                                <Menu.Item as='a' icon>
                                    <Icon name='chevron left' />
                                </Menu.Item>
                                <Menu.Item as='a'>1</Menu.Item>
                                <Menu.Item as='a'>2</Menu.Item>
                                <Menu.Item as='a'>3</Menu.Item>
                                <Menu.Item as='a'>4</Menu.Item>
                                <Menu.Item as='a' icon>
                                    <Icon name='chevron right' />
                                </Menu.Item>
                            </Menu>
                        </Table.HeaderCell>
                    </Table.Row>
                </Table.Footer>
            </Table>
        </div>
    );
}