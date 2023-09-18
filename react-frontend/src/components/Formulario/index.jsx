function Formulario() {
  return (
    <>
      <div>
        <div className="form-group">
          <label>Nome Completo</label>
          <input
            type="text"
            className="form-control"
            placeholder="Digite o nome do funcionário."
          />
        </div>

        <div className="form-group">
          <label>Matrícula</label>
          <input
            type="text"
            className="form-control"
            placeholder="Digite a matrícula do funcionário."
          />
        </div>

        <div className="form-group">
          <label>Setor</label>
          <input
            type="text"
            className="form-control"
            placeholder="Digite o setor do funcionário"
          />
        </div>

        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </div>
    </>
  );
}

export default Formulario;
