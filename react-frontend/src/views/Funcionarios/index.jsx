import {useState, useEffect} from 'react';
import hospitalService from '../../services/hospitalService';
import Tabela from '../../components/Tabela';

function Funcionarios() {
    const [dado, setDado] = useState([]);

    useEffect(() => {
        hospitalService.getAll().then(res => {
            setDado(res.data);
        })
    });

    return (
      <>
        <Tabela
          titulos={["Nome", "Matrícula", "Setor", "Ações"]}
          dados={dado}
        />
      </>
    );
}

export default Funcionarios;