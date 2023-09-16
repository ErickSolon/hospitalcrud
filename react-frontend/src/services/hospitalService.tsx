import axios from "axios";
import Funcionarios from "../models/funcionarios";

class HospitalService {
    baseURL = "http://127.0.0.1:8080/api/hospital";

    save(funcionario: Funcionarios) {
        return axios.post(this.baseURL, funcionario);
    }
    
    getAll() {
        return axios.get(this.baseURL);
    }

    getById(id: number) {
        return axios.get(this.baseURL + "/" + id);
    }

    updateById(id: number, funcionario: Funcionarios) {
        return axios.put(this.baseURL + "/" + id, funcionario);
    }

    deleteById(id: number) {
        return axios.delete(this.baseURL + "/" + id);
    }
}

export default new HospitalService();