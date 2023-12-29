import React from 'react'
import {Dropdown, Image, Menu} from 'semantic-ui-react'

export default function SignedIn({signOut}) {
	return (
		<div>
			<Menu.Item>
				<Image avatar spaced="right" src="https://media.licdn.com/dms/image/D4D03AQGMsTQMwHNTFQ/profile-displayphoto-shrink_800_800/0/1667637413583?e=1709164800&v=beta&t=PnK-H4CKMkMPEH7-Rvxsc6_2D7vVyOBYZArYHcUakc8" />
				<Dropdown pointing="top left" text='Fatih'>

					<Dropdown.Menu>
						<Dropdown.Item text="Bilgilerim" icon="info" />
						<Dropdown.Item onClick={signOut} text="Çıkış yap" icon="sign-out" />
					</Dropdown.Menu>
				</Dropdown>
			</Menu.Item>

		</div>
	)
}
