export interface Itransport {
    id?: number,
    transtortName?: string,
    transportNameENG?: string
}

export class Transport implements Itransport {
    constructor(
        public id?: number,
        public transtortName?: string,
        public transportNameENG?: string
    ){}
}