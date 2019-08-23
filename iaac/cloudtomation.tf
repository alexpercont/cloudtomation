variable "default_project" {
  default = "cloudtomation"
}

variable "default_region" {
  default = "us-central1"
}

provider "google" {
  credentials = "${file("cloudtomation.json")}"
  project = "${var.default_project}"
  region = "${var.default_region}"
}


