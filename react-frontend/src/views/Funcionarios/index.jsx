import {useState, useEffect} from 'react';
import hospitalService from '../../services/hospitalService';

function Funcionarios() {
    const [dado, setDado] = useState([]);

    useEffect(() => {
        hospitalService.getAll().then(res => {
            setDado(res.data);
        })
    });

    const deleteItem = (id) => {
        hospitalService.deleteById(id);
    }

    return (
      <>
        <table className="table table-dark">
          <thead>
            <tr>
              <th>Nome</th>
              <th>Matrícula</th>
              <th>Setor</th>
              <th>Ações</th>
            </tr>
          </thead>
          <tbody>
            {dado.map((element) => {
              return (
                <tr key={element.id}>
                  <td>{element.nome}</td>
                  <td>{element.matricula}</td>
                  <td>{element.setor.setor}</td>
                  <td>
                    <button
                      className="btn btn-danger"
                      onClick={() => deleteItem(element.id)}
                    >
                      Delete
                    </button>
                    <a
                      className="btn btn-warning"
                      href={"/funcionario/" + element.id}
                    >
                      Update
                    </a>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </table>
      </>
    );
}

export default Funcionarios;