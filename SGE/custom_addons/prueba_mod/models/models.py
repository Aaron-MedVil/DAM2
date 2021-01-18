# -*- coding: utf-8 -*-

from odoo import models, fields, api


class prueba_mod(models.Model):
    _name = 'prueba_mod.prueba_mod'
    _description = 'prueba_mod.prueba_mod'

    name = fields.Char(string  = "Brand")
#     name = fields.Char()
#     value = fields.Integer()
#     value2 = fields.Float(compute="_value_pc", store=True)
#     description = fields.Text()
#
#     @api.depends('value')
#     def _value_pc(self):
#         for record in self:
#             record.value2 = float(record.value) / 100
