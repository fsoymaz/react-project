import { Icon, Menu, Table } from 'semantic-ui-react';
import React, { useState, useEffect } from 'react';
import BrandService from '../services/brandService';

export default function ProductList() {
	const [brands, setBrands] = useState([]);

	useEffect(() => {
		let brandService = new BrandService();
		brandService
			.getBrands()
			.then(result => setBrands(result.data.data))
			.catch(error => console.log(error.message));
	}, []);

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
							<Table.Cell>{brand.name}</Table.Cell>
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
