export interface ITypeOfAnimal {
    id?: number,
    typeName?: string,
    typeNameEng?: string,
    specificNameEng?: string
}

export class TypeOfAnimal implements ITypeOfAnimal {
    constructor(
        public id?: number,
        public typeName?: string,
        public typeNameEng?: string,
        public specificNameEng?: string
    ) {}
}