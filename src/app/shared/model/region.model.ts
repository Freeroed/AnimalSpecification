export interface IRegion {
        id?: number,
        name?: string,
        nameEng?: string
}
export class Region implements IRegion{
    constructor(
        public id?: number,
        public name?: string,
        public nameEng?: string
    ) {}
}