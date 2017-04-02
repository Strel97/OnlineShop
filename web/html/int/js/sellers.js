
function SellerAPI() {
}

SellerAPI.prototype.getAllSellers = function( callback ) {
    Rest.getData('rest/manufacturer/get/all', function( data ) {
        callback( data.results );
    });
};
