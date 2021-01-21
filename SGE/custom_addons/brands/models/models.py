# -*- coding: utf-8 -*-

from odoo import models, fields, api


class Brand(models.Model):
    _name = 'brand.template'
    _description = 'Brands'

    name = fields.Char(string="Brand")
    logo = fields.Image(string="Logo")

class CustomBrand(models.Model):
    _inherit = 'product.template'
    
    brand = fields.Selection([("N", "Nike"), ("A", "Adidas")], string="Brand", help="Seleccione la marca")

