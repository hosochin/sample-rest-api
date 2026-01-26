# Orders API 仕様書

## 概要
注文情報を取得するAPIエンドポイント

## エンドポイント

### GET /orders
注文一覧を取得する

**レスポンス例:**
```json
[
  {
    "id": 1,
    "productName": "商品A",
    "quantity": 2,
    "createdAt": "2024-01-01T00:00:00"
  }
]
```

## DB設計

### ordersテーブル
| カラム名 | 型 | 説明 |
|---------|-----|------|
| id | BIGINT | 主キー（自動採番） |
| product_name | VARCHAR(255) | 商品名 |
| quantity | INT | 数量 |
| created_at | TIMESTAMP | 作成日時 |

## 環境構成
- Java / Spring Boot
- MySQL 8.0（Docker）
- ポート: 8080（API）, 3306（MySQL）
