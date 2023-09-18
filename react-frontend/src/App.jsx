import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Home from './views/Home'
import Funcionarios from "./views/Funcionarios";
import AddFuncionario from './views/AddFuncionario';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='' element={<Home />}></Route>
          <Route path='/funcionarios' element={<Funcionarios />}></Route>
          <Route path='/add' element={<AddFuncionario />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
