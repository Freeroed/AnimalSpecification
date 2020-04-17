export interface IRosselkhoznadzorDivision {
    id?: number,
    name?: string,
    nameEmg?: string
}

export class RosselkhoznadzorDivision implements IRosselkhoznadzorDivision {
    constructor(
        public id?: number,
        public name?: string,
        public nameEmg?: string) {}
}