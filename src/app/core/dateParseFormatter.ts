import { Injectable } from '@angular/core';
import { NgbDateParserFormatter, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Injectable()
export class DateParserFormatter extends NgbDateParserFormatter {
  readonly DELIMITER = '.';

  parse(value: string): NgbDateStruct {
    if (value) {
      const dateParts = value.trim().split('/');
      if (dateParts.length === 1 && this.isNumber(dateParts[0])) {
        return { year: this.toInteger(dateParts[0]), month: null, day: null };
      } else if (dateParts.length === 2 && this.isNumber(dateParts[0]) && this.isNumber(dateParts[1])) {
        return { year: this.toInteger(dateParts[1]), month: this.toInteger(dateParts[0]), day: null };
      } else if (dateParts.length === 3 && this.isNumber(dateParts[0]) && this.isNumber(dateParts[1]) && this.isNumber(dateParts[2])) {
        return { year: this.toInteger(dateParts[2]), month: this.toInteger(dateParts[0]), day: this.toInteger(dateParts[1]) };
      }
    }
    return null;
  }

  format(date: NgbDateStruct): string {
    let stringDate: string = "";
    if (date) {
      stringDate += this.isNumber(date.month) ? this.padNumber(date.month) + "/" : "";
      stringDate += this.isNumber(date.day) ? this.padNumber(date.day) + "/" : "";
      stringDate += date.year;
    }
    return stringDate;
  }

  private padNumber(value: number) {
    if (this.isNumber(value)) {
      return `0${value}`.slice(-2);
    } else {
      return "";
    }
  }

  private isNumber(value: any): boolean {
    return !isNaN(this.toInteger(value));
  }

  private toInteger(value: any): number {
    return parseInt(`${value}`, 10);
  }
}
