Интернет магазин

Презентация файлы - "Онлайн магазин.pptx", "Онлайн магазин.pdf"

В начале убедиться, что nginx ingress запущен

```
minikube addons  enable ingress
```

Создаем и делаем дефолтным неймспейс auth
```
kubectl create ns auth
kubectl config set-context --current --namespace=auth
```

Устанавливаем весь стек - прометей + оператор + графана
```
cd prometheus
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update
helm install stack prometheus-community/kube-prometheus-stack -f prometheus.yaml
```

Собираем и запускаем с помощью helm сервис аутентификации
```
cd ../auth-service
helm install auth chart/ --values chart/auth-values.yaml
```

Собираем и запускаем с помощью helm сервис billing
```
cd ../billing-service
helm install billing-service chart/ --values chart/billing-values.yaml
```

Собираем и запускаем с помощью helm сервис cart (корзина)
```
cd ../cart-service
helm install cart-service chart/ --values chart/cart-values.yaml
```

Собираем и запускаем с помощью helm сервис catalog-service (каталог)
```
cd ../catalog-service
helm install catalog-service chart/ --values chart/catalog-values.yaml
```

Собираем и запускаем с помощью helm сервис delivery-service (корзина)
```
cd ../delivery-service
helm install delivery-service chart/ --values chart/delivery-values.yaml
```

Собираем и запускаем с помощью helm сервис notification-service (сервис сообщений)
```
cd ../notification-service
helm install notification-service chart/ --values chart/notification-values.yaml
```

Собираем и запускаем с помощью helm сервис order-service (сервис заказов)
```
cd ../order-service
helm install order-service chart/ --values chart/order-values.yaml
```

Собираем и запускаем с помощью helm сервис payment-service (сервис внешней оплаты)
```
cd ../payment-service
helm install payment-service chart/ --values chart/payment-values.yaml
```

Собираем и запускаем с помощью helm сервис warehouse-service (сервис склада)
```
cd ../warehouse-service
helm install warehouse-service chart/ --values chart/warehouse-values.yaml
```

Применяем манифсты для сервисов
```
cd ..
kubectl apply -f auth-ingress.yaml
kubectl apply -f billing-ingress.yaml
kubectl apply -f cart-ingress.yaml
kubectl apply -f catalog-ingress.yaml
kubectl apply -f delivery-ingress.yaml
kubectl apply -f notification-ingress.yaml
kubectl apply -f orders-ingress.yaml
kubectl apply -f payment-ingress.yaml
kubectl apply -f warehouse-ingress.yaml
```

Прокидываем порт и можем посмотреть прометей 
на http://127.0.0.1:9090/
```
kubectl port-forward service/prometheus-operated  9090
```

Прокидываем порт и можем посмотреть графану
на http://localhost:9000
```
kubectl port-forward service/stack-grafana  9000:80
```

После настройки
Запускаем тесты с помощью postman и проверяем, что все корректно запустилось.
в папке postman коллекция

