import { Formik, Form, Field, ErrorMessage } from 'formik'
import React from 'react'
import * as Yup from 'yup'
import { Button, FormField } from 'semantic-ui-react'
import TobetoTextInput from '../utilities/customFormControls/TobetoTextInput'
export default function ProductAdd() {
	const initialValues = { productName: '', unitPrice: 10 }
	const validationSchema = Yup.object({
		productName: Yup.string().required('Ürün adı zorunlu'),
		unitPrice: Yup.number().required('Ürün fiyatı zorunlu'),
	})

	return (
			<Formik

				initialValues={initialValues}
				validationSchema={validationSchema}
				onSubmit={(values) => {
					console.log(values)
				}}
			>
				<Form className='ui form'>
					<TobetoTextInput name='productName' placeholder='Ürün Adı' />
					<TobetoTextInput name='unitPrice' placeholder='Ürün Fiyatı' />
					<Button color='green' type='submit'>Ekle</Button>
				</Form>
			</Formik>
	)
}
