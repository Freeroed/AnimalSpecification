export interface ICountry {
    id?: number,
    region?: number,
    countryName?: string,
    ISOcode?: string,
    countryNameENG?: string,
    regionOfTheCountry?: string,
    regionOfTheCountryENG?: string
}
export class Country implements ICountry{
constructor(
    public id?: number,
    public region?: number,
    public countryName?: string,
    public ISOcode?: string,
    public countryNameENG?: string,
    public regionOfTheCountry?: string,
    public regionOfTheCountryENG?: string
) {}
}