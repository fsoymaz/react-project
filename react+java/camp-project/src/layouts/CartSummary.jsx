import React from 'react'
import { useSelector } from 'react-redux'
import { Dropdown, Label } from 'semantic-ui-react'
import { NavLink } from 'react-router-dom'


export default function CartSummary() {
	const { cartItems } = useSelector(state => state.cart)
	return (
		<div>
			<Dropdown item text='Sepetiniz'>
				<Dropdown.Menu>
					{cartItems.map((cartItem) => (
						<Dropdown.Item key={cartItem.product.id}>
							{cartItem.product.name}
							<Label color="blue">{cartItem.quantity}</Label>
							<Dropdown.Divider />
						</Dropdown.Item>
					))}
					<Dropdown.Divider />
					<Dropdown.Item as={NavLink} to="/cart">Sepete Git</Dropdown.Item>
				</Dropdown.Menu>
			</Dropdown>
		</div>
	)
}
