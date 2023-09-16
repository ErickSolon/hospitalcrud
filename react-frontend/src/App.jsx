import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Home from './views/Home'
import Funcionarios from "./views/Funcionarios";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path='' element={<Home />}></Route>
          <Route path='/funcionarios' element={<Funcionarios />}></Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
