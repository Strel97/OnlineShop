
function Product() {
    this.name = "";
    this.description = "";
    this.image = "";
    this.price = 0;
    this.quantity = 0;
}

function ProductAPI() {
}

ProductAPI.prototype.getAllProducts = function( callback ) {
    Rest.getData('rest/product/get/all', function( data ) {
        callback( data.results );
    });
};
