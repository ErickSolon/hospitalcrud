import { Component } from "react";
import PropTypes from "prop-types";
import hospitalService from "../../services/hospitalService";

class Tabela extends Component {
  deleteItem(id) {
    hospitalService.deleteById(id);
  }

  render() {
    return (
      <>
        <table className="table table-dark">
          <thead>
            <tr>
              {this.props.titulos.map((e) => (
                <th key={e}>{e}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {this.props.dados.map((element) => {
              return (
                <tr key={element.id}>
                  <td>{element.nome}</td>
                  <td>{element.matricula}</td>
                  <td>{element.setor.setor}</td>
                  <td>
                    <button
                      className="btn btn-danger"
                      onClick={() => this.deleteItem(element.id)}
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
}

Tabela.propTypes = {
  titulos: PropTypes.array,
  dados: PropTypes.array,
};

export default Tabela;
