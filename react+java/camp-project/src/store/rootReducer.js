import { combineReducers } from "redux";
import cartReducer from "./reducers/cartReducer";

const rootReducer = combineReducers({
	cart : cartReducer,
	  // other reducers
	});

	export default rootReducer;