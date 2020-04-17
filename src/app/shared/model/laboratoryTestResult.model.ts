export interface ILaboratoryTestResult {
    id?: number,
    resultName?: string,
    resultNameENG?: string
}
export class LaboratoryTestResult implements ILaboratoryTestResult{
    constructor(
        public id?: number,
        public resultName?: string,
        public resultNameENG?: string
    ){}
}