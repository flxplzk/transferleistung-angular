export class Product {
  private _id: number;
  private _description: string;
  private _priceInCents: number;
  private _active: boolean;

  constructor(id: number, description: string, priceInCents: number, active: boolean) {
    this._id = id;
    this._description = description;
    this._priceInCents = priceInCents;
    this._active = active;
  }

  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get description(): string {
    return this._description;
  }

  set description(value: string) {
    this._description = value;
  }

  get priceInCents(): number {
    return this._priceInCents;
  }

  set priceInCents(value: number) {
    this._priceInCents = value;
  }

  get active(): boolean {
    return this._active;
  }

  set active(value: boolean) {
    this._active = value;
  }
}
