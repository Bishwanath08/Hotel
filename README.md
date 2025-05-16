{
	"info": {
		"_postman_id": "7b6f90dd-266b-4ae9-ab50-a9e6cb73d3c2",
		"name": "Hotels",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "44380712",
		"_collection_link": "https://bishwanath-6014551.postman.co/workspace/Bishwanath-'s-Workspace~5f7d3d00-69c1-42e3-832a-17f0fc96b931/collection/44380712-7b6f90dd-266b-4ae9-ab50-a9e6cb73d3c2?action=share&source=collection_link&creator=44380712"
	},
	"item": [
		{
			"name": "New Request",
			"request": {
				"method": "GET",
				"header": []
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/hotel/filter",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n//   \"city\": \"Delhi\",\r\n//   \"minPrice\": 1000,\r\n//   \"maxPrice\": 5000,\r\n//   \"roomType\": \"SUITE\",\r\n\r\n     \"searching\": \" Paradise Hotel\"\r\n  \r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/hotel/filter",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"hotel",
						"filter"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/users/login",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "7f19f964-09f0-498b-b876-4fb0c229f921_fadd1d18-ae7b-4078-b553-922211520ed1",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "accept",
						"value": "application/json"
					},
					{
						"key": "Content-Type",
						"value": "application/json"
					},
					{
						"key": "Authorization",
						"value": "Bearer ece431c9-1639-4e54-8ec6-d3ab6513dc41_dafa3f21-adfb-46a5-9da3-538cccc20d66"
					},
					{
						"key": "Bearer",
						"value": "ece431c9-1639-4e54-8ec6-d3ab6513dc41_dafa3f21-adfb-46a5-9da3-538cccc20d66",
						"type": "default",
						"disabled": true
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\n  \"email\": \"kavu@gmail.com\",\n \"password\": \"123456\"\n\n}"
				},
				"url": {
					"raw": "http://localhost:8080/users/login",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users",
						"login"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/admin/login",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "15b255d7-aa44-468f-82cc-7d68360d3960_d9d313fd-afe9-4394-8bbb-21617a942780",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": " {\r\n    // \"name\": \"Abnana\",\r\n    // \"email\": \"Abnana@gamil.com\",\r\n    // \"password\": \"123456\",\r\n    // \"phone\": \"555555343525\"\r\n\r\n  \"email\": \"Abnana@gamil.com\",\r\n \"password\": \"123456\"\r\n\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/admin/login",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"admin",
						"login"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/admin/rooms/add/5",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "06539561-877d-4975-a09b-4057b8fd747e_c6b769d7-e6e8-4f5c-9824-b7b97809ae75",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "Authorization",
						"value": "your_admin_token_here",
						"type": "default"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n  \"name\": \" ParadRAniise Hotel\",\r\n  \"address\": \" Beach Road\",\r\n  \"city\": \"Goa\",\r\n  \"contact\": \"9555228543210\"\r\n\r\n\r\n//   \"roomNumber\":  \"405G\", \r\n//   \"price\": 7200,\r\n//   \"available\": true,\r\n//   \"roomType\": \"SINGLE\"\r\n  \r\n\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/admin/rooms/add/5",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"admin",
						"rooms",
						"add",
						"5"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/hotel/5",
			"event": [
				{
					"listen": "test",
					"script": {
						"exec": [
							"var template = `\r",
							"<canvas id=\"errorChart\" height=\"75\"></canvas>\r",
							"\r",
							"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js\"></script> \r",
							"\r",
							"<script>\r",
							"    var ctx = document.getElementById(\"errorChart\");\r",
							"\r",
							"    var errorChart = new Chart(ctx, {\r",
							"        type: \"bar\",\r",
							"        data: {\r",
							"            labels: [\"Error\"],\r",
							"            datasets: [{\r",
							"                data: [1],\r",
							"                \r",
							"                // Change these colours to customize the chart\r",
							"                backgroundColor: [\"#ff0000\"],\r",
							"            }]\r",
							"        },\r",
							"        options: {\r",
							"            legend: { display: false },\r",
							"            title: {\r",
							"                display: true,\r",
							"                text: 'Error Occurrence'\r",
							"            },\r",
							"            scales: {\r",
							"                xAxes: [{\r",
							"                    display: true,\r",
							"                    scaleLabel: {\r",
							"                        display: true,\r",
							"                        labelString: 'Error Type'\r",
							"                    }\r",
							"                }],\r",
							"                yAxes: [{\r",
							"                    display: true,\r",
							"                    scaleLabel: {\r",
							"                        display: true,\r",
							"                        labelString: 'Count'\r",
							"                    }\r",
							"                }]\r",
							"            }\r",
							"        }\r",
							"\r",
							"    });\r",
							"\r",
							"    pm.getData(function (err, value) {\r",
							"        errorChart.data.datasets[0].data = [1];\r",
							"        errorChart.data.labels = [\"Error\"];\r",
							"        errorChart.update();\r",
							"    });\r",
							"\r",
							"</script>`;\r",
							"\r",
							"function constructVisualizerPayload() {\r",
							"    return {response: {error: \"Something went wrong!\"}};\r",
							"}\r",
							"\r",
							"pm.visualizer.set(template, constructVisualizerPayload());"
						],
						"type": "text/javascript",
						"packages": {}
					}
				}
			],
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "GET",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n  \"userId\": 1,\r\n  \"hotelId\": 3,\r\n  \"roomId\": 5,\r\n  \"checkInDate\": \"2025-05-01\",\r\n  \"checkOutDate\": \"2025-05-05\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/hotel/5",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"hotel",
						"5"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/booking",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "POST",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer f3f1768e-285b-443a-a7ce-e781245ea786_fac2ca5c-521a-4ce1-8bbb-49f020e798ec",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "// {\r\n//   \"userId\": 10,\r\n//   \"hotelId\": 1,\r\n//   \"roomId\": 102,\r\n//   \"checkInDate\": \"2025-05-02\",\r\n//   \"checkOutDate\": \"2025-05-10\"\r\n// }\r\n\r\n\r\n// {\r\n//   \"bookingNumber\": \"BK12345\",\r\n//   \"checkInDate\": \"2025-05-25\",\r\n//   \"checkOutDate\": \"2025-05-30\",\r\n//   \"hotelId\":3,\r\n//   \"roomId\": 52,\r\n//   \"totalAmount\": 4120.50,\r\n//   \"userId\": 2\r\n// }\r\n\r\n\r\n{\r\n  \"hotelId\": 3,\r\n  \"roomType\": \"SINGLE\",   \r\n  \"checkInDate\": \"2025-06-10\",\r\n  \"checkOutDate\": \"2025-06-15\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/booking/admin",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"booking",
						"admin"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/hotel/filter",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n//   \"city\": \"Delhi\",\r\n//   \"minPrice\": 1000,\r\n//   \"maxPrice\": 5000,\r\n//   \"roomType\": \"SUITE\",\r\n\r\n     \"searching\": \" Paradise Hotel\"\r\n  \r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/hotel/filter",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"hotel",
						"filter"
					]
				}
			},
			"response": []
		},
		{
			"name": "verify-Otp",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n     \"email\": \"kavu@gmail.com\",\r\n     \"otp\" : \"0001\"\r\n\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/users/verify-otp",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users",
						"verify-otp"
					]
				}
			},
			"response": []
		},
		{
			"name": "register",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\r\n     \"name\": \"kavu\",\r\n    \"email\": \"kavu@gmail.com\",\r\n    \"password\": \"123456\",\r\n    \"phone\": \"55555544477\",\r\n     \"role\": \"CUSTOMER\"\r\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/users/register",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"users",
						"register"
					]
				}
			},
			"response": []
		},
		{
			"name": "customer-book",
			"request": {
				"auth": {
					"type": "bearer",
					"bearer": [
						{
							"key": "token",
							"value": "21672f71-691d-4771-bf40-780bf6a8fef6_fabceee6-452f-4509-8e49-87e66403d1b8",
							"type": "string"
						}
					]
				},
				"method": "POST",
				"header": [
					{
						"key": "Authorization",
						"value": "Bearer 443a924f-2f56-4071-9a76-a24d1477be07_4fa2c524-c1da-45f5-8a0b-0e473cab95ef",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\r\n  \"userId\": 10,\r\n  \"hotelId\": 3,\r\n  \"roomType\": \"SINGLE\",\r\n  \"checkInDate\": \"2025-09-18\",\r\n  \"checkOutDate\": \"2025-09-23\"\r\n}\r\n",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "http://localhost:8080/booking/customer-book",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"booking",
						"customer-book"
					]
				}
			},
			"response": []
		}
	],
	"variable": [
		{
			"key": "token",
			"value": "",
			"type": "default"
		}
	]
}
