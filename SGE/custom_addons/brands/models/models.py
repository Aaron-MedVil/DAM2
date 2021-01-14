# -*- coding: utf-8 -*-

from odoo import models, fields, api

class CustomBrand(models.Model):
    _inherit = 'product.template'
    brand = fields.Selection([("N", "Nike"), ("A", "Adidas")], string="Brand")

# class Brand(models.Model):
#    _name = 'brand.template'
#    _description = 'brand.template'
#    name = fields.Char(string='Brand')