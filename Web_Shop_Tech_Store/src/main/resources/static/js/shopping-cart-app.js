/**
 *
 */

const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function($scope, $http) {
	// quản lí giỏ hàng
	$scope.cart = {
		items: [],

		//thêm sản phẩm vào giỏ hàng
		add(id) {
			var item = this.items.find((item) => item.id == id);
			if (item) {
				item.qty++;
				this.saveToLocalStorage;
			} else {
				$http.get(`/rest/products/${id}`).then((resp) => {
					resp.data.qty = 1;
					this.items.push(resp.data);
					this.saveToLocalStorage();
				});
			}
		},

		// xoá sản phẩm khỏi giỏ hàng
		remove(id) {
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index, 1);
			this.saveToLocalStorage();
		},

		// xoá toàn bộ sản phẩm trong giỏ hàng
		clear() {
			this.items = [];
			this.saveToLocalStorage();
		},

		//tính thành tiền của 1 sản phẩm
		amt_of(item) { },

		// tính tổng số lượng các mặt hàng trong giỏ
		get count() {
			return this.items
				.map((item) => item.qty)
				.reduce((total, qty) => (total += qty), 0);
		},

		// tính tổng thành tiền các mặt hàng trong giỏ
		get amount() {
			return this.items
				.map((item) => item.qty * item.price)
				.reduce((total, qty) => (total += qty), 0);
		},

		// lưu giỏ hàng vào local storage
		saveToLocalStorage() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		},

		// đọc giỏ hàng từ local storage
		loadFormLocalStorage() {
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json) : [];
		},
	};


	$scope.cart.loadFormLocalStorage();
	$scope.order = {
       create_date: new Date(),
       address:"",
       account:{username:$("#username").text()},
       get orderDetails(){
            return $scope.cart.items.map(item => {
                return{
                    product:{id:item.id},
                    price:item.price,
                    quantity:item.qty
                }
            });
       },
       purchase(){
           var order = angular.copy(this);
           $http.post("/rest/orders",order).then(resp => {
               alert("Đặt hàng thành công!");
               $scope.cart.clear();
               location.href="/order/detail/"+resp.data.id;
           }).catch(error =>{
               alert("Đặt Hàng Lỗi!")
               console.log(error)
           })
       }
   }
});









