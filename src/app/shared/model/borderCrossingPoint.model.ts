export interface IBorderCrossingPoint {
    id?: number,
    location?: string,
    adjacentPoint?: string,
    classification?: string,
    schedule?: string,
    scheduleOfManagementOfficials?: string
}
export class BorderCrossingPoint implements IBorderCrossingPoint {
    constructor (
        public id?: number,
        public location?: string,
        public adjacentPoint?: string,
        public classification?: string,
        public schedule?: string,
        public scheduleOfManagementOfficials?: string
    ){}
}