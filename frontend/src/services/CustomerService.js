import {apiCall} from "./ApiService";

export const getCustomer = (id) => {
    return apiCall("/customers/" + id, "GET");
};