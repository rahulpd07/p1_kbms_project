package com.revature.kbms.model;

public class Order {

	public Order() {
		// TODO Auto-generated constructor stub
	}
		private int orderId;
		private int productId;
		private int quantity;
		private double totalPrice;
		private String orderDate;
		private String status;
		private int cancellationId;
		private String cancellationDate;
		private String cancellationReason;
		private String preffered_login_Id;
		
		public Order(int orderId, int productId, int quantity, double totalPrice, String orderDate, String status,
				int cancellationId, String cancellationDate, String cancellationReason, String preffered_login_Id) {
			super();
			this.orderId = orderId;
			this.productId = productId;
			this.quantity = quantity;
			this.totalPrice = totalPrice;
			this.orderDate = orderDate;
			this.status = status;
			this.cancellationId = cancellationId;
			this.cancellationDate = cancellationDate;
			this.cancellationReason = cancellationReason;
			this.preffered_login_Id = preffered_login_Id;
		}

		public int getOrderId() {
			return orderId;
		}

		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}

		public int getProductId() {
			return productId;
		}

		public void setProductId(int productId) {
			this.productId = productId;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}

		public String getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(String orderDate) {
			this.orderDate = orderDate;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getCancellationId() {
			return cancellationId;
		}

		public void setCancellationId(int cancellationId) {
			this.cancellationId = cancellationId;
		}

		public String getCancellationDate() {
			return cancellationDate;
		}

		public void setCancellationDate(String cancellationDate) {
			this.cancellationDate = cancellationDate;
		}

		public String getCancellationReason() {
			return cancellationReason;
		}

		public void setCancellationReason(String cancellationReason) {
			this.cancellationReason = cancellationReason;
		}

		public String getPreffered_login_Id() {
			return preffered_login_Id;
		}

		public void setPreffered_login_Id(String preffered_login_Id) {
			this.preffered_login_Id = preffered_login_Id;
		}

		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", totalPrice="
					+ totalPrice + ", orderDate=" + orderDate + ", status=" + status + ", cancellationId=" + cancellationId
					+ ", cancellationDate=" + cancellationDate + ", cancellationReason=" + cancellationReason
					+ ", preffered_login_Id=" + preffered_login_Id + "]";
		}
		
		
		
     
	}
	 
    

