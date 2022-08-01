export class Product {


    constructor(
        public id: number,
        public sku: string,
        public name: string,
        public desciption: string,
        public unit_price: number,
        public imageurl: string,
        public units_in_stock: number,
        public price: number,
        public datecreated: Date,
        public lastUpdated: Date,
        public categoryId: number

    ) { }
}
