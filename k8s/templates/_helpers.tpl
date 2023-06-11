{{/* Generate basic labels */}}
{{- define "vez-srv.v1.labels" }}
  labels:
    generator: helm
    date: {{ now | htmlDate }}
    appName: {{ .Chart.Name | upper | quote }}
    appVersion: {{ .Chart.AppVersion }}
{{- end }}
