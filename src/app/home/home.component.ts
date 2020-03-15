import { Component, OnInit } from '@angular/core';
import { Region } from './../shared/model/region.model'

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html'
})

export class HomeComponent implements OnInit {
    regs: Region[] = [
        {id: 1, name: 'Страны Евросоюза'},
        {id: 2, name: 'Регионы России'}
    ]

    constructor() { }
    ngOnInit(){
        console.log(this.regs);
    }
}