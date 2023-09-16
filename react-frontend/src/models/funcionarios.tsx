import Setor from "./setor"

export default interface Funcionarios {
    id?: number
    nome: string
    matricula: string
    setor: Setor
}