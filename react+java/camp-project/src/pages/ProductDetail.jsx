import React from 'react'
import { useParams } from 'react-router-dom'
import { Card, Image, Button } from 'semantic-ui-react'

export default function ProductDetail() {
	let { id } = useParams() // category id varsa yanına yazarız
	return (
		<div>
			<Card.Group>
				<Card fluid>
					<Card.Content>
						<Image
							floated='right'
							size='mini'
							src='/images/avatar/large/steve.jpg'
						/>
						<Card.Header>Steve Sanders</Card.Header>
						<Card.Meta>Friends of Elliot</Card.Meta>
						<Card.Description>
							Steve wants to add you to the group <strong>best friends</strong>
						</Card.Description>
					</Card.Content>
					<Card.Content extra>
						<div className='ui two buttons'>
							<Button basic color='green'>
								Approve
							</Button>
							<Button basic color='red'>
								Decline
							</Button>
						</div>
					</Card.Content>
				</Card>
			</Card.Group>
		</div>
	)
}
