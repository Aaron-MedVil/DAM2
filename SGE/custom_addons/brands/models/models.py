# -*- coding: utf-8 -*-

from odoo import models, fields, api

## Modelo del formulario para crear un registro
class Brand(models.Model):
    _name = 'brand.template'
    _description = 'Brands'

    name = fields.Char(string="Brand")
    logo = fields.Image(string="Logo")
    description = fields.Char(string="Description")

## Modelo para la vista de producto
class CustomBrand(models.Model):
    _inherit = 'product.template'
    
    brand = fields.Selection([("N", "Nike"), ("A", "Adidas")], string="Brand", help="Seleccione la marca")